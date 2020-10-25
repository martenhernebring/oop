package se.hernebring.business.accounting;

import se.hernebring.utils.ShellUtils;

class Transaction {
    private int referenceNo;
    private final long payment;
    private final String buyer, seller;
    private boolean successful = false;

    Transaction(int referenceNo, long payment, String seller, String buyer) {
        if (payment <= 0) {
            System.out.println("Betalningen ska ha ett positivt värde. Skriv in:");
            payment = ShellUtils.scan.nextInt();
            ShellUtils.scan.nextLine();
        }
        if (seller.equals("")) {
            System.out.println("Det måste finnas en säljarföretag på betalningen. Skriv på nytt:");
            seller = ShellUtils.scan.nextLine();
        }
        if (buyer.equals("")) {
            System.out.println("Det måste finnas ett köpeföretag på betalningen. Skriv på nytt:");
            buyer = ShellUtils.scan.nextLine();
        }
        this.referenceNo = referenceNo;
        this.payment = payment;
        this.seller = seller;
        this.buyer = buyer;
    }

    @Override
    public String toString() {
        return "ReferenceNo: " + referenceNo + "\tPayment: " + payment + "\tSeller: " + seller + "\tBuyer: " + buyer + "\tDone: " + successful;
    }

	int getReferenceNo() {
		return referenceNo;
	}

	long getPayment() {
		return payment;
	}

	String getBuyer() {
		return buyer;
	}

	String getSeller() {
		return seller;
	}

    void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    boolean isSuccessful() {
        return successful;
    }

}