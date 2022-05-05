package by.epam.unit_4.task_15;

/*
task15: Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки различного типа
(отдых, экскурсии, лечение, шопинг, круиз и т. д.) для оптимального выбора. Учитывать возможность выбора транспорта,
питания и числа дней. Реализовать выбор и сортировку путевок.
 */

//      разобраться с выводом в строку, чтобы каждая путевка была с новой строки
//      сейчас выводит просто в строку, в квадратных скобках
//      + дописать поиск путевки по параметрам (по стране, дням, питанию и т.д.)

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        TravelVoucher stambul = new TravelVoucher("Turkey", "Stambul", TypeVoucher.REST, Transport.AIRPLANE, Nutrition.ALL_INCLUSIVE, 10);
        TravelVoucher kiev = new TravelVoucher("Ukraine", "Kiev", TypeVoucher.EXCURSION, Transport.TRAIN, Nutrition.WITHOUT_NUTRITION, 4);
        TravelVoucher losAngeles = new TravelVoucher("USA", "LA", TypeVoucher.REST, Transport.AIRPLANE, Nutrition.BREAKFAST, 11);
        TravelVoucher bukovel = new TravelVoucher("Ukraine", "Bukovel", TypeVoucher.TREATMENT, Transport.BUS, Nutrition.THREE_MEALS, 21);

        List<TravelVoucher> travelVouchers = new ArrayList<>() {{
            add(stambul);
            add(kiev);
            add(losAngeles);
            add(bukovel);
        }};

        VoucherOffers voucherOffers = new VoucherOffers(travelVouchers);

        voucherOffers.sortByDays();
    }
}
