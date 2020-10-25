package se.hernebring.business.accounting;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import se.hernebring.utils.ShellUtils;

class Invoice {
    private static int year;
    private int invoiceNo;
    private final long startDebt;
    private long currentDebt;
    private final String buyer, seller, bContact, sContact;
    private boolean isPaid = false;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;

    private static int getYear() {
        return LocalDateTime.now().getYear();
    }

    Invoice(long startDebt, String seller, String sContact, String buyer, String bContact) {
        if (startDebt <= 0) {
            System.out.println("Skulden ska ha ett positivt värde. Skriv på nytt:");
            startDebt = ShellUtils.scan.nextInt();
            ShellUtils.scan.nextLine();
        }
        if (seller.equals("")) {
            System.out.println("Det måste finnas en säljarföretag på fakturan. Skriv på nytt:");
            seller = ShellUtils.scan.nextLine();
        }
        if (sContact.equals("")) {
            System.out.println("Det måste finnas en säljarkontakt på fakturan. Skriv på nytt:");
            sContact = ShellUtils.scan.nextLine();
        }
        if (buyer.equals("")) {
            System.out.println("Det måste finnas ett köpeföretag på fakturan. Skriv på nytt:");
            buyer = ShellUtils.scan.nextLine();
        }
        if (bContact.equals("")) {
            System.out.println("Det måste finnas en köparkontakt på fakturan. Skriv på nytt:");
            bContact = ShellUtils.scan.nextLine();
        }
        int currentYear = getYear();
        if (currentYear == year) {
            invoiceNo++;
        } else {
            year = currentYear;
            invoiceNo = (2219 - year) * 10_000_000 + 1;
        }
        this.startDebt = startDebt;
        currentDebt = startDebt;
        this.seller = seller;
        this.sContact = sContact;
        this.buyer = buyer;
        this.bContact = bContact;
        issueDate = LocalDateTime.now();
        dueDate = issueDate.plusDays(30);
    }

    void setPaid(boolean paid) {
        this.isPaid = paid;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDateTime = dueDate.format(formatter);
        return "InvoiceNo: " + invoiceNo + "\tDebt: " + currentDebt + "\tSeller: " + seller 
        + " " +sContact + "\nBuyer: " + buyer+ "\tContact: " + bContact+"\tDue:" + formattedDateTime +" Paid:" + isPaid; 
    }

	int getInvoiceNo() {
		return invoiceNo;
	}

    long getStartDebt() {
        return startDebt;
    }

    String getBuyer() {
        return buyer;
    }

    String getSeller() {
        return seller;
    }

    boolean isPaid() {
        return isPaid;
    }

    String getbContact() {
        return bContact;
    }

    String getsContact() {
        return sContact;
    }

}