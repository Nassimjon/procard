package nassim.procard.model;

import jakarta.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int orderId;
    public String clientPAN;
    public int clientMBR;
    public String serviceCode;
    public String firstName;
    public String secondName;
    public String firstNameOnCard;
    public String secondNameOnCard;
    public String cardDateInput;
    public String cardDateExpire;
    public String fullNameOnEnv;
    public String nameBank;
    public String cardStatus;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getClientPAN() {
        return clientPAN;
    }

    public void setClientPAN(String clientPAN) {
        this.clientPAN = clientPAN;
    }

    public int getClientMBR() {
        return clientMBR;
    }

    public void setClientMBR(int clientMBR) {
        this.clientMBR = clientMBR;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFirstNameOnCard() {
        return firstNameOnCard;
    }

    public void setFirstNameOnCard(String firstNameOnCard) {
        this.firstNameOnCard = firstNameOnCard;
    }

    public String getSecondNameOnCard() {
        return secondNameOnCard;
    }

    public void setSecondNameOnCard(String secondNameOnCard) {
        this.secondNameOnCard = secondNameOnCard;
    }

    public String getCardDateInput() {
        return cardDateInput;
    }

    public void setCardDateInput(String cardDateInput) {
        this.cardDateInput = cardDateInput;
    }

    public String getCardDateExpire() {
        return cardDateExpire;
    }

    public void setCardDateExpire(String cardDateExpire) {
        this.cardDateExpire = cardDateExpire;
    }

    public String getFullNameOnEnv() {
        return fullNameOnEnv;
    }

    public void setFullNameOnEnv(String fullNameOnEnv) {
        this.fullNameOnEnv = fullNameOnEnv;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(String cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String passportNo;
}
