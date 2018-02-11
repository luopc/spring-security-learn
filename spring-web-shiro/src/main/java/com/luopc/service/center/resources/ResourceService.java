package com.luopc.service.center.resources;

import java.util.Set;

import com.luopc.base.center.resource.model.Resource;

public interface ResourceService {

	Set<Resource> selectResourceCollectionByRoleId(String id);

}
