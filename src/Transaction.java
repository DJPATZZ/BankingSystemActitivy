public class Transaction {
    private String transactionHistory;
    private String referenceNum;


    public Transaction(String TransactionHistory, String referenceNum){
        setTransactionHistory(TransactionHistory);
        setReferenceNum(referenceNum);
    }

    public String getHistory(){
        return this.transactionHistory;
    }
    public String getReferenceNum(){
        return this.referenceNum;
    }
    public void setTransactionHistory(String TransactionHistory){
        this.transactionHistory = TransactionHistory;
    }
    public void setReferenceNum(String referenceNum){
        this.referenceNum = referenceNum;
    }

}
