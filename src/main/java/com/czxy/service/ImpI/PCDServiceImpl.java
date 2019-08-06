package com.czxy.service.ImpI;

import com.czxy.dao.PCDMapper;
import com.czxy.domain.PCD;
import com.czxy.service.PCDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class PCDServiceImpl implements PCDService {
    @Resource
    private PCDMapper pcdMapper;
    @Override
    public List<PCD> findAll() {
        return pcdMapper.findAllProvince();
    }

    @Override
    public List<PCD> findById(String id) {
        return pcdMapper.findById(id);
    }

    @Override
    public PCD findPCD(String id) {
        return pcdMapper.selectByPrimaryKey(id);
    }
}
