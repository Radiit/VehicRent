package com.TubesRpl.vehicrent;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import com.TubesRpl.repository.ClientRepository;
import com.TubesRpl.repository.KendaraanRepository;
import com.TubesRpl.repository.RegentRepository;
import com.TubesRpl.repository.TransaksiRepository;
import com.TubesRpl.vehicrent.backend.models.Client;
import com.TubesRpl.vehicrent.backend.models.Kendaraan;
import com.TubesRpl.vehicrent.backend.models.Regent;
import com.TubesRpl.vehicrent.backend.models.Transaksi;
import com.TubesRpl.vehicrent.backend.payloads.requests.TransaksiRequest;
import com.TubesRpl.vehicrent.backend.payloads.response.Response;
import com.TubesRpl.vehicrent.backend.services.TransaksiServices;

@ExtendWith(MockitoExtension.class)
public class TransaksiServiceTest {

    @Mock
    TransaksiRepository transaksiRepository;

    @Mock
    ClientRepository clientRepository;

    @Mock
    RegentRepository regentRepository;

    @Mock
    KendaraanRepository kendaraanRepository;

    @InjectMocks
    TransaksiServices transaksiServices;

    private Transaksi transaksi;
    private TransaksiRequest transaksiRequest;

    @BeforeEach
    public void setup() {
        transaksi = new Transaksi();
        transaksi.setIdTransaksi(1);

        transaksiRequest = new TransaksiRequest(0, 0, 0, "", "", "", "", "", Date.valueOf(LocalDate.now()), Date.valueOf(LocalDate.now()));
        transaksiRequest.setID_Kendaraan(1);
        transaksiRequest.setID_Kendaraan(1);
        transaksiRequest.setID_Regent(1);
        transaksiRequest.setID_Client(1);
        transaksiRequest.setOrderName("test");
        transaksiRequest.setPhoneNumber("test");
        transaksiRequest.setPickUpAddress("test");
        transaksiRequest.setDropOffAddress("test");
        transaksiRequest.setDestination("test");

        LocalDate rentDateStart = LocalDate.parse("2021-01-01");
        transaksiRequest.setRentDateStart(Date.valueOf(rentDateStart));

        LocalDate rentDateEnd = LocalDate.parse("2021-01-01");
        transaksiRequest.setRentDateEnd(Date.valueOf(rentDateEnd));
    }

    @Test
    public void testCreateTransaksi() {
        when(clientRepository.findByHiddenFalseAndIdClient(anyInt())).thenReturn(Optional.of(new Client()));
        when(regentRepository.findByHiddenFalseAndIdRegent(anyInt())).thenReturn(Optional.of(new Regent()));
        when(kendaraanRepository.findByHiddenFalseAndIdKendaraan(anyInt())).thenReturn(Optional.of(new Kendaraan()));
        when(transaksiRepository.save(any(Transaksi.class))).thenReturn(transaksi);

        Response response = transaksiServices.Create(transaksiRequest);

        assertEquals(HttpStatus.OK.value(), response.getStatus());
        assertEquals("Success", response.getMessage());
        assertNotNull(response.getData());
        assertTrue(response.getData() instanceof Transaksi);
    }
}
