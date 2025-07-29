package com.kaleshrikant.billing;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shrikant Kale
 * @Date 7/29/25
 */

@Repository
public interface BillingRecordRepository extends JpaRepository<BillingRecord, Long> {
}
