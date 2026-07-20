public class Transaction {

    private String transactionHistory;
    private String referenceNum;

    public Transaction(String transactionHistory,
                       String referenceNum) {
        this.transactionHistory = transactionHistory;
        this.referenceNum = referenceNum;
    }

    public String getHistory() {
        return transactionHistory;
    }

    public String getReferenceNum() {
        return referenceNum;
    }

    public void setTransactionHistory(
            String transactionHistory
    ) {
        this.transactionHistory = transactionHistory;
    }

    public void setReferenceNum(String referenceNum) {
        this.referenceNum = referenceNum;
    }
}