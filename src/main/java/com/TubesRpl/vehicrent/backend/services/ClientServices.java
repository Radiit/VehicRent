package com.TubesRpl.vehicrent.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.UserRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Rekomendasi;
import com.TubesRpl.vehicrent.backend.models.User;
import com.TubesRpl.vehicrent.backend.payloads.requests.ClientRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;

@Service
public class ClientServices implements RoleServices<ClientRequest>{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userrepository;
    @Autowired 
    private BaseServices<Rekomendasi> rekomendasiServices;
    
    @Override
    public Response DisplayAllData(){
        List<Client> allClient = new ArrayList<>();
        clientRepository.findAll().forEach(allClient::add);
        for (Client client : allClient){
            System.out.println("ID Client: " + client.getID_Client());
            System.out.println("NIK User: " + client.getUser());
        }
        return new Response(HttpStatus.OK.value(), "Success", allClient);
    }

    @Override
    public Response Create(ClientRequest request){
        try{
            User user = userrepository.findById(request.getNIK_User()).orElse(null);
            if (user == null){
                return new Response(HttpStatus.NOT_FOUND.value(), "User not found", request);
            }
            Client client = new Client();
            client.setUser(user);
            client.setNoSIM(request.getNo_SIM());
            Rekomendasi rekomendasi = new Rekomendasi();
            rekomendasiServices.Create(rekomendasi);
            client.setRekomendasi(rekomendasi);
            clientRepository.save(client);
            return new Response(HttpStatus.OK.value(), "Success", request);
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", request);
        }
    }

    @Override
    public Response Update(Integer id, ClientRequest request){
        try{
            Client client = clientRepository.findById(id).orElse(null);
            if (client != null){
                client.setUser(client.getUser());
                client.setNoSIM(request.getNo_SIM());
                System.out.println(request.getNo_SIM());
                client.setRekomendasi(client.getRekomendasi());
                clientRepository.save(client);
                return new Response(HttpStatus.OK.value(), "Success", client);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Delete(Integer id){
        try{
            Client client = clientRepository.findById(id).orElse(null);
            if (client != null){
                clientRepository.deleteById(id);
                return new Response(HttpStatus.OK.value(), "Success", client);
            }else{
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response DisplayByID(Integer id){
        try {
            Client client = clientRepository.findById(id).orElse(null);
            if (client != null) {
                System.out.println("ID Client: " + client.getID_Client());
                System.out.println("NIK User: " + client.getUser().getNIK_User());
                System.out.println("No SIM: " + client.getNoSIM());
                System.out.println("ID Rekomendasi: " + client.getRekomendasi());
                return new Response(HttpStatus.OK.value(), "Success", client);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
}
