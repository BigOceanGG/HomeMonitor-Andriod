package com.ocean.homemonitor.account;

public class Account {
    private long nonce;
    private String network;
    private String seed;
    private String address;
    private String publicKey;

    public Account() {
    }

    public Account(String seed, long nonce, String network,String version) {
        this.seed = seed;
        this.nonce = nonce;
        this.network = network;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getSeed() {
        return seed;
    }
}
