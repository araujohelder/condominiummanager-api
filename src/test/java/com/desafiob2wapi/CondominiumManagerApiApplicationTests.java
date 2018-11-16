package com.desafiob2wapi;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.condominiummanagerapi.service.CondominiumService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CondominiumManagerApiApplicationTests {
	
	 @Autowired
	 CondominiumService condominiumService;
	
	 @Before
     public void setUp() {
     }
	 
	
	@Test
    public void setsIdOnSave() {
	 	
    }

    @Test
    public void findsBytName() {
    	
    }

    @Test
    public void findAll() {
        
    }
    
    @Test
    public void removePlanet() {
    	
    }
}
