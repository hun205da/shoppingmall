package com.myshop.shop.repository;

import com.myshop.shop.constant.CouponStatus;
import com.myshop.shop.dto.*;
import com.myshop.shop.entity.Coupon;
import com.myshop.shop.entity.QCoupon;
import com.myshop.shop.entity.QItem;
import com.myshop.shop.entity.QItemImg;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class CouponRepositoryCustomImpl implements CouponRepositoryCustom {
    private JPAQueryFactory queryFactory;

    public CouponRepositoryCustomImpl(EntityManager em){
        this.queryFactory = new JPAQueryFactory(em);
    }

    private BooleanExpression searchStatusEq(CouponStatus searchStatus){
        return searchStatus == null ? null : QCoupon.coupon.couponStatus.eq(searchStatus);
    }

    private BooleanExpression regDtsAfter(String searchDateType){

        LocalDateTime dateTime = LocalDateTime.now();

        if(StringUtils.equals("all", searchDateType) || searchDateType == null){
            return null;
        } else if(StringUtils.equals("1d", searchDateType)){
            dateTime = dateTime.minusDays(1);
        } else if(StringUtils.equals("1w", searchDateType)){
            dateTime = dateTime.minusWeeks(1);
        } else if(StringUtils.equals("1m", searchDateType)){
            dateTime = dateTime.minusMonths(1);
        } else if(StringUtils.equals("6m", searchDateType)){
            dateTime = dateTime.minusMonths(6);
        }

        return QCoupon.coupon.regTime.after(dateTime);
    }

    private BooleanExpression searchByLike(String searchBy, String searchQuery){

        if(StringUtils.equals("CouponNm", searchBy)){
            return QCoupon.coupon.couponNm.like("%" + searchQuery + "%");
        } else if(StringUtils.equals("createdBy", searchBy)){
            return QCoupon.coupon.couponNm.like("%" + searchQuery + "%");
        }

        return null;
    }

    @Override
    public Page<Coupon> getAdminCouponPage(CouponSearchDto couponSearchDto, Pageable pageable) {

        List<Coupon> content = queryFactory
                .selectFrom(QCoupon.coupon)
                .where(regDtsAfter(couponSearchDto.getSearchDateType()),
                        searchStatusEq(couponSearchDto.getSearchStatus()),
                        searchByLike(couponSearchDto.getSearchBy(),
                                couponSearchDto.getSearchQuery()))
                .orderBy(QCoupon.coupon.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory.select(Wildcard.count).from(QCoupon.coupon)
                .where(regDtsAfter(couponSearchDto.getSearchDateType()),
                        searchStatusEq(couponSearchDto.getSearchStatus()),
                        searchByLike(couponSearchDto.getSearchBy(), couponSearchDto.getSearchQuery()))
                .fetchOne()
                ;

        return new PageImpl<>(content, pageable, total);
    }
    private BooleanExpression couponNmLike(String searchQuery){
        return StringUtils.isEmpty(searchQuery) ? null : QCoupon.coupon.couponNm.like("%" + searchQuery + "%");
    }

    @Override
    public Page<MainCouponDto> getMainCouponPage(CouponSearchDto couponSearchDto, Pageable pageable) {
        QCoupon coupon = QCoupon.coupon;

        List<MainCouponDto> content = queryFactory
                .select(
                        new QMainCouponDto(
                                coupon.id,
                                coupon.couponNm,
                                coupon.discount)
                )
                .where(couponNmLike(couponSearchDto.getSearchQuery()))
                .orderBy(coupon.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        long total = queryFactory
                .select(Wildcard.count)
                .where(couponNmLike(couponSearchDto.getSearchQuery()))
                .fetchOne();

        return new PageImpl<>(content, pageable, total);
    }
}
