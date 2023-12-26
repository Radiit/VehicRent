package com.TubesRpl.vehicrent.backend.services;

import com.TubesRpl.vehicrent.backend.payloads.response.Response;

public interface RoleServices<TypeRequest> {
    Response Create(TypeRequest request);
    Response Update(Integer id, TypeRequest request);
    Response Delete(Integer id);
    Response DisplayAllData();
    Response DisplayByID(Integer id);
}
