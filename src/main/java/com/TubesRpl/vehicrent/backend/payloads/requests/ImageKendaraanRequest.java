package com.TubesRpl.vehicrent.backend.payloads.requests;

public class ImageKendaraanRequest {
    private Integer ID_ImageKendaraan;
    private String image;

    public ImageKendaraanRequest() {
        this.ID_ImageKendaraan = 0;
    }

    public ImageKendaraanRequest(Integer ID_ImageKendaraan, String image) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
        this.image = image;
    }

    public Integer getID_ImageKendaraan() {
        return ID_ImageKendaraan;
    }

    public void setID_ImageKendaraan(Integer ID_ImageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String dirImage) {
        this.image = dirImage;
    }

}