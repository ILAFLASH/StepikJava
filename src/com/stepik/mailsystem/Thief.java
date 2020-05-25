package com.stepik.mailsystem;

/**
 * 3) Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе
 * переменную int – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен
 * присутствовать метод getStolenValue, который возвращает суммарную стоимость всех посылок, которые он своровал.
 * Воровство происходит следующим образом: вместо посылки, которая пришла вору, он отдает новую, такую же,
 * только с нулевой ценностью и содержимым посылки "stones instead of {content}".
 */
public class Thief implements MailService {
    private int minPrice;
    private int stolenValue;

    public Thief(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getStolenValue() {
        return stolenValue;
    }

    @Override
    public Sendable processMail(Sendable mail) {
        if (mail instanceof MailPackage && ((MailPackage) mail).getContent().getPrice() >= minPrice) {
            stolenValue += ((MailPackage) mail).getContent().getPrice();
            Package newPackage = new Package("stones instead of " + ((MailPackage) mail).getContent().getContent(), 0);
            mail = new MailPackage(mail.getFrom(), mail.getTo(), newPackage);
        }
        return mail;
    }
}
