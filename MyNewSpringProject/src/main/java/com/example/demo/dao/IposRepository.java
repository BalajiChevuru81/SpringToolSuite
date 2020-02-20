package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.pojos.IposPlanned;

public interface IposRepository<IposPlanned> extends CrudRepository<IposPlanned, Integer > {


}


