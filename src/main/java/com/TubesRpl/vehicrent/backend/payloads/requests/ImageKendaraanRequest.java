package com.TubesRpl.vehicrent.backend.payloads.requests;

public class ImageKendaraanRequest {
    private Integer ID_ImageKendaraan;
    private String dirImage;

    public ImageKendaraanRequest() {
        this.ID_ImageKendaraan = 0;
    }

    public ImageKendaraanRequest(Integer ID_ImageKendaraan, String imageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
        dirImage = imageKendaraan;
    }

    public Integer getID_ImageKendaraan() {
        return ID_ImageKendaraan;
    }

    public void setID_ImageKendaraan(Integer ID_ImageKendaraan) {
        this.ID_ImageKendaraan = ID_ImageKendaraan;
    }

    public String getImageKendaraan() {
        return dirImage;
    }

    public void setImageKendaraan(String dirImage) {
        this.dirImage = dirImage;
    }

}
