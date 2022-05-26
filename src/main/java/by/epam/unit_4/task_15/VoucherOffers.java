package by.epam.unit_4.task_15;

import java.util.Comparator;
import java.util.List;

public class VoucherOffers {
    private List<TravelVoucher> travelVouchers;

    public VoucherOffers(List<TravelVoucher> travelVouchers) {
        this.travelVouchers = travelVouchers;
    }

    //    набор предложений по заданным параметрам
    public void getOffer(Transport transport, Nutrition nutrition, int days) {
        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getTransport().equals(transport)
                    && travelVoucher.getNutrition().equals(nutrition)
                    && travelVoucher.getNumberOfDays() == days) {
                System.out.println(travelVoucher);
            }
        }
    }

    private void sortByCountry() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getCountry)
                .thenComparing(TravelVoucher::getLocation));
    }

    private void sortByLocation() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getLocation));
    }

    private void sortByTypeVoucher() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getTypeVoucher));
    }

    private void sortByTransport() {
        travelVouchers.sort(Comparator.comparing(TravelVoucher::getTransport));
    }

    private void sortByNutrition() {
        travelVouchers.sort(Comparator.comparingInt(x -> x.getNutrition().ordinal()));
    }

    private void sortByDays() {
        travelVouchers.sort(Comparator.comparingInt(TravelVoucher::getNumberOfDays));
    }

    public void searchByCountry(String country) {
        sortByCountry();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getCountry().equalsIgnoreCase(country)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public void searchByLocation(String location) {
        sortByLocation();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getLocation().equalsIgnoreCase(location)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public void searchByTypeVoucher(TypeVoucher typeVoucher) {
        sortByTypeVoucher();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getTypeVoucher().equals(typeVoucher)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public void searchByTransport(Transport transport) {
        sortByTransport();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getTransport().equals(transport)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public void searchByNutrition(Nutrition nutrition) {
        sortByNutrition();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getNutrition().equals(nutrition)) {
                System.out.println(travelVoucher);
            }
        }
    }

    public void searchByDays(int days) {
        sortByDays();

        for (TravelVoucher travelVoucher : travelVouchers) {
            if (travelVoucher.getNumberOfDays() == days) {
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
        } else return "";
    }
}
