package com.TubesRpl.vehicrent.backend.services;

import org.springframework.stereotype.Service;

import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public interface BaseServices<TypeModel> {
    Response Create(TypeModel model);

    Response Update(Integer id, TypeModel model);

    Response Delete(Integer id);

    Response DisplayAllData();

    Response DisplayByID(Integer id);
}
