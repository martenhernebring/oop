package se.hernebring.business.accounting;
class InvoiceApp {

    public static void main(String[] args) {
        final String s1 = "Alpha has ", s2 = " incoming payments and Beta has ", s3 = " outgoing payments.";
        Company alpha = new Company("alpha", "Alpha Hane");
        Company beta = new Company("beta", "Beta Hane");
        System.out.println(s1 + alpha.getIncoming() + s2 + beta.getOutgoing() + s3);

        final int VALUE = 1000;
        System.out.println("Beta bought " + VALUE + " SEK goods.");
        Invoice invoice = new Invoice(VALUE, alpha.getCompany(), alpha.getContact(), beta.getCompany(),
                beta.getContact());
        alpha.addCredit(invoice);
        beta.addDebit(invoice);
        System.out.println(invoice);
        System.out.println(s1 + alpha.getIncoming() + s2 + beta.getOutgoing() + s3);

        Transaction transaction = new Transaction(invoice.getInvoiceNo(), VALUE, alpha.getCompany(), beta.getCompany());
        beta.addCredit(transaction);
        alpha.addDebit(transaction);
        if (invoice.isPaid() && transaction.isSuccessful()) {
            System.out.println("Beta 1000 SEK transaction to Alpha was successful!");
        }
        System.out.println(invoice + "\n" + transaction);
        System.out.println(s1 + alpha.getIncoming() + s2 + beta.getOutgoing() + s3);
    }

}
