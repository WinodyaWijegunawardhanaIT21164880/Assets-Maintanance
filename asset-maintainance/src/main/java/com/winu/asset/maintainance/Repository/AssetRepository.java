package com.winu.asset.maintainance.Repository;

import com.winu.asset.maintainance.Model.Assets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



import java.util.Optional;

import java.util.List;


@Repository
public interface AssetRepository extends MongoRepository<Assets, String> {
  @Override
  Optional<Assets> findById(String s);

  <Assets> void findByBarcode(String barcode);
  List<Assets> findByLocation(String location);



  @Repository
  public interface AssetsRepository extends MongoRepository<Assets, String> {
    Optional<Assets> findByBarcode(String barcode);
  }

}




