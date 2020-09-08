/* Licensed under Apache-2.0 */
package com.smartship.mds.springdata.repository;

import com.smartship.mds.springdata.entity.Address;

import ro.common.springdata.CommonCrudRepository;

/**
 * Sample repository implementation for SpringData
 *
 * @author r.krishnakumar
 */
public interface AddressRepository extends CommonCrudRepository<Address, Long> {

}
