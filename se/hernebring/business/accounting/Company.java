package se.hernebring.business.accounting;
import java.util.LinkedList;
import java.util.List;

class Company {
    private String company, contact;
    private List<Invoice> creditInvoices, debitInvoices;
    private long credit, debit;

    Company(String company, String contact) {
        this.company = company;
        this.contact = contact;
        creditInvoices = new LinkedList<>();
        debitInvoices = new LinkedList<>();
    }

    @Override
    public String toString() {
        return company + "\tContact: " + contact + "\tCredit: " + credit + "\tDebit: " + debit;
    }

    String getCompany() {
        return company;
    }

    void setCompany(String company) {
        this.company = company;
    }

    String getContact() {
        return contact;
    }

    void setContact(String contact) {
        this.contact = contact;
    }

    void addDebit(Invoice invoice) {
        if (invoice.getBuyer().equals(company) && invoice.getbContact().equals(contact)) {
            debit = invoice.getStartDebt();
            debitInvoices.add(0, invoice);
        }
    }

    void addDebit(Transaction t) {
        long payment = t.getPayment();
        if (t.getSeller().equals(company)) {
            for (Invoice i : creditInvoices) {
                if (t.getReferenceNo() == i.getInvoiceNo() && payment == i.getStartDebt()
                        && t.getBuyer().equals(i.getBuyer())) {
                    t.setSuccessful(true);
                    credit -= payment;
                    creditInvoices.remove(i);
                    return;
                }
            }
        }
        debit += payment;
        return;
    }

    void addCredit(Invoice invoice) {
        if (invoice.getSeller().equals(company) && invoice.getsContact().equals(contact)) {
            credit = invoice.getStartDebt();
            creditInvoices.add(0, invoice);
        }
    }

    void addCredit(Transaction t) {
        long payment = t.getPayment();
        if (t.getBuyer().equals(company)) {
            for (Invoice i : debitInvoices) {
                if (t.getReferenceNo() == i.getInvoiceNo() && payment == i.getStartDebt()
                        && t.getSeller().equals(i.getSeller())) {
                    i.setPaid(true);
                    debitInvoices.remove(i);
                    debit -= payment;
                    return;
                }
            }
        }
        credit += t.getPayment();
        return;
    }

    int getIncoming() {
        return creditInvoices.size();
    }

    int getOutgoing() {
        return debitInvoices.size();
    }
}
