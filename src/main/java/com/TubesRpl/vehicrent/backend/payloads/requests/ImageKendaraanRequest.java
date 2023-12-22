package com.TubesRpl.vehicrent.backend.payloads.requests;

public class ImageKendaraanRequest {
    private Integer ID_ImageKendaraan;
    private String ImageKendaraan;

    public ImageKendaraanRequest() {
        this.ID_ImageKendaraan = 0;
    }

    public ImageKendaraanRequest(Integer ID_ImageKendaraan, String imageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
        ImageKendaraan = imageKendaraan;
    }

    public Integer getID_ImageKendaraan() {
        return ID_ImageKendaraan;
    }

    public void setID_ImageKendaraan(Integer ID_ImageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
    }

    public String getImageKendaraan() {
        return ImageKendaraan;
    }

    public void setImageKendaraan(String imageKendaraan) {
        ImageKendaraan = imageKendaraan;
    }

}
