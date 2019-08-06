package com.czxy.service;

import com.czxy.domain.PCD;

import java.util.List;

public interface PCDService {
    public List<PCD> findAll();
    public List<PCD> findById(String id);
    public PCD findPCD(String id);
}
