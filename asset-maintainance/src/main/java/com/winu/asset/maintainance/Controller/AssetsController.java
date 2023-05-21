package com.winu.asset.maintainance.Controller;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.winu.asset.maintainance.Model.Assets;
import com.winu.asset.maintainance.Repository.AssetsRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/assets")
public class AssetsController {

    public final AssetsRepository assetRepository;

    public AssetsController(AssetsRepository assetRepository) {
        this.assetRepository = assetRepository;
    }

    @GetMapping("data")
    public Assets getData() {
        System.out.println("HIT");
        Assets myData = new Assets();
        myData.setName("Chair");
                myData.setCategory("Furniture");
                myData .setValue("03");
               myData. setLocation("Main Hall");
                myData.setDetails("black colour");
                myData.setPurchaseDate("23/03/2023");
                myData.setBarcode("");
                myData.setPurchaseCost("Rs2000");
                myData.setVendor("Damro");
                myData.setDisposed(Boolean.parseBoolean("false"));
        return myData;
    }

    @GetMapping("/barcode/{barcode}")
    public Assets getAssetByBarcode(@PathVariable String barcode) throws ChangeSetPersister.NotFoundException {
        return (Assets) assetRepository.findByBarcode(barcode).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @JsonBackReference
    @GetMapping("/location/{location}")
    public List<Assets> getAssetsByLocation(@PathVariable String location) {
        return assetRepository.findByLocation(location);
    }

    @GetMapping("/{id}")
    public Optional<Assets> getAssetById(@PathVariable String id) {
        return assetRepository.findById(id);
    }

    @PostMapping("/save")
    public Assets addAsset(@RequestBody Assets assets) {
        return assetRepository.save(assets);
    }

    @PutMapping("/{id}")
    public Assets updateAssets(@PathVariable String id, @RequestBody Assets assets) {
        assets.setId(id);
        return assetRepository.save(assets);
    }

    @DeleteMapping("/{id}")
    public void deleteAssets(@PathVariable String id) {
        assetRepository.deleteById(id);
    }
    @JsonBackReference
    @GetMapping("/disposed")
    public List<Assets> getDisposedAssets() {
        return assetRepository.findByDisposed(true);
    }
    @JsonBackReference
    @GetMapping("/undisposed")
    public List<Assets> getUndisposedAssets() {
        return assetRepository.findByDisposed(false);
    }
}
