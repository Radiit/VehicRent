package com.TubesRpl.vehicrent.backend.services;

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
public class ClientServices implements BaseServices<ClientRequest>{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserRepository userrepository;
    @Autowired 
    private BaseServices<Rekomendasi> rekomendasiServices;
    
    @Override
    public Response DisplayAllData(){
        List<Client> allClient = clientRepository.findAllByHiddenFalse();
        if (allClient.isEmpty()){
            return new Response(HttpStatus.NOT_FOUND.value(), "No Client Found", null);
        }
        System.out.println("Display all client data");
        return new Response(HttpStatus.OK.value(), "Success", allClient);
    }

    @Override
    public Response Create(ClientRequest request){
        try{
            User user = userrepository.findByHiddenFalseAndNik(request.getNik()).orElse(null);
            if (user == null){
                return new Response(HttpStatus.NOT_FOUND.value(), "User not exist", null);
            }
            Client client = new Client();
            client.setUser(user);
            client.setSim(request.getSim());
            Rekomendasi rekomendasi = new Rekomendasi();
            rekomendasiServices.Create(rekomendasi);
            client.setRekomendasi(rekomendasi);
            client.setHidden(false);
            client.setValid("Pending");
            clientRepository.save(client);
            System.out.println("Create new client with id: " + client.getIdClient() + " and NIK: " + client.getUser().getNIK_User());
            return new Response(HttpStatus.OK.value(), "Success", client);
        }catch(Exception e){
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }

    @Override
    public Response Update(Integer id, ClientRequest request){
        try{
            Client client = clientRepository.findByHiddenFalseAndIdClient(id).orElse(null);
            if (client != null){
                client.setUser(client.getUser());
                client.setSim(request.getSim());
                client.setHidden(false);
                client.setValid("Pending");
                clientRepository.save(client);
                System.out.println("Update client with id: " + client.getIdClient());
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
                client.setHidden(true);
                clientRepository.save(client);
                System.out.println("Delete client with id: " + client.getIdClient());
                return new Response(HttpStatus.OK.value(), "Success", null);
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
            Client client = clientRepository.findByHiddenFalseAndIdClient(id).orElse(null);
            if (client != null) {
                System.out.println("Display client by id : " + id);
                return new Response(HttpStatus.OK.value(), "Success", client);
            } else {
                return new Response(HttpStatus.NOT_FOUND.value(), "Client not found", null);
            }
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST.value(), "Failed", null);
        }
    }
}
