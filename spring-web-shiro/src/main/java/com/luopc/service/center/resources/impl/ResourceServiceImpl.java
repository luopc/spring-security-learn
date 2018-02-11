package com.luopc.service.center.resources.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luopc.base.center.resource.dao.ResourceMapper;
import com.luopc.base.center.resource.model.Resource;
import com.luopc.service.center.resources.ResourceService;
@Service
@Transactional
public class ResourceServiceImpl implements ResourceService {
	
	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public Set<Resource> selectResourceCollectionByRoleId(String id) {		
		return resourceMapper.selectResourceCollectionByRoleId(id);
	}

}
