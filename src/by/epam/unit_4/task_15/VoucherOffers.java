package by.epam.unit_4.task_15;

import java.util.Comparator;
import java.util.List;

public class VoucherOffers {
    private List<TravelVoucher> travelVouchers;

    public VoucherOffers(List<TravelVoucher> travelVouchers) {
        this.travelVouchers = travelVouchers;
    }

    public void sortByCountry() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getCountry));
        System.out.println(travelVouchers);
    }

    public void sortByLocation() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getLocation));
        System.out.println(travelVouchers);
    }

    public void sortByTypeVoucher() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getTypeVoucher));
        System.out.println(travelVouchers);
    }

    public void sortByTransport() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getTransport));
        System.out.println(travelVouchers);
    }

    public void sortByNutrition() {
        travelVouchers.sort(Comparator.comparingInt(x -> x.getNutrition().getFlag()));
        System.out.println(travelVouchers);
    }

    public void sortByDays() {
        travelVouchers.sort(Comparator.comparingInt(TravelVoucher::getNumberOfDays));
        System.out.println(travelVouchers);
    }

    public void searchByCountry(String country) {
        sortByCountry();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getCountry().equalsIgnoreCase(country)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public List<TravelVoucher> getTravelVouchers() {
        return travelVouchers;
    }

    public void setTravelVouchers(List<TravelVoucher> travelVouchers) {
        this.travelVouchers = travelVouchers;
    }

    @Override
    public String toString() {
        if (travelVouchers != null) {
            StringBuilder stringBuilder = new StringBuilder();

            travelVouchers.forEach(x -> stringBuilder.append(x).append("\n"));

            return stringBuilder.toString();
        } else return null;
    }

//    @Override
//    public String toString() {
//        if (this.travelVouchers != null) {
//            StringBuilder tpSet = new StringBuilder();
//            for (TravelVoucher tp : travelVouchers) {
//                tpSet.append(tp.toString()).append(";\n");
//            }
//            return tpSet.toString();
//        } else {
//            return "Список туристических путевок пуст.";
//        }
//    }
}
