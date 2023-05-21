package com.winu.asset.maintainance.Repository;

import com.winu.asset.maintainance.Model.Assets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetsRepository extends MongoRepository<Assets, String> {
    List<Assets> findByDisposed(boolean disposed);

    Optional<Object> findByBarcode(String barcode);

    List<Assets> findByLocation(String location);


}
