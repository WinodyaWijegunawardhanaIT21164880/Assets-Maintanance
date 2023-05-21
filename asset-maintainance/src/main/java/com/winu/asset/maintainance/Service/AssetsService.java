package com.winu.asset.maintainance.Service;

import com.winu.asset.maintainance.Model.Assets;
import com.winu.asset.maintainance.Repository.AssetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssetsService {

    @Autowired
    private AssetsRepository assetRepository;

    public List<Assets> getAllAssets() {
        return assetRepository.findAll();
    }

    public Assets getAssetById(Long id) {
        Optional<Assets> asset = assetRepository.findById(String.valueOf(id));
        if(asset.isPresent()) {
            return asset.get();
        } else {
            throw new RuntimeException("Asset not found with id: " + id);
        }
    }

    public Assets createAsset(Assets asset) {
        return assetRepository.save(asset);
    }

    public void deleteAsset(Long id) {
        assetRepository.deleteById(String.valueOf(id));
    }

    public Assets updateAsset(Long id, Assets asset) {
        Optional<Assets> optionalAsset = assetRepository.findById(String.valueOf(id));
        if (optionalAsset.isPresent()) {
            Assets existingAsset = optionalAsset.get();
            existingAsset.setName(asset.getName());
            existingAsset.setCategory(asset.getCategory());
            existingAsset.setPurchaseDate(asset.getPurchaseDate());
            existingAsset.setPurchaseCost(asset.getPurchaseCost());
            existingAsset.setVendor(asset.getVendor());
            return assetRepository.save(existingAsset);
        } else {
            throw new RuntimeException("Asset not found with id: " + id);
        }
    }
}