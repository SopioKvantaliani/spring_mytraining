package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository <Region, Integer> {

    //Display all regions in Canada
    List<Region> findByCountry(String country); //we need List because there are many regions
    List <Region> getByCountry(String country); //Same as findBy. We can use either of them.


    //Display all regions with country name includes "United"
    List<Region> findByCountryContaining(String country);

    //Display all regions with country name includes "United" in region order;
     List<Region> findByCountryContainingOrderByRegionDesc(String country);

     //Display top 2 Regions in United States
    List<Region> findTopByCountry (String country);
    List<Region> findTop2ByCountry (String country); //this will show us first 2 top country and etc.

    List<Region> findTopByCountryContainingOrderByRegion(String country);







}
