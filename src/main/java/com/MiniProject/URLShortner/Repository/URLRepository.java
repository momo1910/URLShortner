package com.MiniProject.URLShortner.Repository;

import com.MiniProject.URLShortner.Entities.URL;
import com.MiniProject.URLShortner.Models.URLStatsResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface URLRepository extends JpaRepository<URL,Integer> {
    @Query(value = "select shortcode from Uniform_Resource_Locator where shortcode=?1",nativeQuery = true )
    public String getShortLinkIfExists(String shortLink);

    @Transactional
    @Modifying
    @Query(value="update Uniform_Resource_Locator set count=count+1 where shortenurl=?1",nativeQuery = true)
    public void updateStats(String shortcode);

    @Query(value = "select long_Url from Uniform_Resource_Locator where long_Url=?1",nativeQuery = true )
    public String getLongLinkIfExists(String request);

    @Query(value = "select shortenurl from Uniform_Resource_Locator where long_Url=?1",nativeQuery = true )
    public String getShortLinkIfLongUrlExists(String request);

    @Query(value = "select shortenurl from Uniform_Resource_Locator",nativeQuery = true )
    public List<String> getAllShortUrl();

    @Query(value="select long_url from Uniform_Resource_Locator where shortenurl=?1 ",nativeQuery = true)
    public String getCompleteURL(String shortURL);

    @Transactional
    @Modifying
    @Query(value = "update Uniform_Resource_Locator set count=count+1",nativeQuery = true )
    public void updateStatsAll();

    @Transactional
    @Modifying
    @Query(value = "update Uniform_Resource_Locator set count=count+1 where shortenurl=?1",nativeQuery = true )
    public void updateStatsShortURL(String shortURL);


    @Query(value="select * from Uniform_Resource_Locator" , nativeQuery = true)
    List<URL> getAllStats();
}
