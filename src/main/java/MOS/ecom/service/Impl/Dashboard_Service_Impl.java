package MOS.ecom.service.Impl;

import MOS.ecom.entity.Customer_Entity;
import MOS.ecom.entity.Item_Entity;
import MOS.ecom.entity.Order_Entity;
import MOS.ecom.repository.Customer_repository;
import MOS.ecom.repository.Item_repository;
import MOS.ecom.repository.Order_repository;
import MOS.ecom.service.Dashboard_Service;
import MOS.ecom.util.Category;
import MOS.ecom.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

@Service
@RequiredArgsConstructor
public class Dashboard_Service_Impl implements Dashboard_Service {

    private final Order_repository order_repo;
    private final Item_repository item_repo;
    private final Customer_repository customer_repo;


    @Override
    public Double getTotalRevenueInCurrentMonth() {
        Iterable<Order_Entity> all = order_repo.findAll();

        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(today);

        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();

        all.forEach(order -> {
            if (order.getOrderDate() != null && YearMonth.from(order.getOrderDate()).equals(currentMonth)) stats.accept(order.getTotalAmount());
        });

        return stats.getSum();
    }

    @Override
    public List<Object> getRevenueByLast6Month() {
        LocalDate now = LocalDate.now();

        List<Object> revenues = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            LocalDate lastMonths = now.minusMonths(i).withDayOfMonth(1);
            YearMonth month = YearMonth.from(lastMonths);

            double total = 0.0;
            for (Order_Entity order : order_repo.findAll()) {
                if (order.getOrderDate() != null &&
                        YearMonth.from(order.getOrderDate()).equals(month)) {
                    total += order.getTotalAmount();
                }
            }

            revenues.add(total);
        }
      return revenues;
    }

    @Override
    public Integer getAllCustomerCount() {
        List<Customer_Entity> all =(List<Customer_Entity>) customer_repo.findAll();
        return all.size();
    }

    @Override
    public Integer getAllOrderCount() {
        List<Order_Entity> all =(List<Order_Entity>) order_repo.findAll();
        return all.size();
    }

    @Override
    public List<Object> getAllOrderCuntByStatus() {
        int pending = 0, delivered = 0, cancelled = 0;
        for (Order_Entity order : order_repo.findAll()) {
            if (order.getStatus() == OrderStatus.Pending) pending++;
            else if (order.getStatus() == OrderStatus.Delivered) delivered++;
            else if (order.getStatus() == OrderStatus.Cancelled) cancelled++;
        }
        return Arrays.asList(pending, delivered, cancelled);
    }

    @Override
    public Double getTotalRevenueToday() {
        double total = 0.0;
        LocalDate today = LocalDate.now(); // Get today’s date once
        for (Order_Entity order : order_repo.findAll()) {
            if (order.getOrderDate() != null && order.getOrderDate().equals(today)) {
                total += order.getTotalAmount();
            }
        }
        return total;
    }

    @Override
    public Double getTotalRevenueYesterday() {
        double total = 0.0;
        LocalDate today = LocalDate.now().minusDays(1);
        for (Order_Entity order : order_repo.findAll()) {
            if (order.getOrderDate() != null && order.getOrderDate().equals(today)) {
                total += order.getTotalAmount();
            }
        }
        return total;
    }

    @Override
    public Double getTotalRevenue() {
        double total = 0.0;
        for (Order_Entity order : order_repo.findAll()) {
            total += order.getTotalAmount();
        }
        return total;
    }

    @Override
    public Double getItemAllItemCount() {
        double total = 0.0;
        for (Item_Entity item : item_repo.findAll()) {
            total += item.getQty();
        }
        return total;
    }

    @Override
    public List<Object> getItemAllItemCountByCategory() {
        Map<String, Double> countByCategory = new HashMap<>();
        for (Item_Entity item : item_repo.findAll()) {
            Category category = item.getCategory();
            if (category != null) {
                String categoryName = category.toString();
                Double qty = item.getQty() != null ? item.getQty() : 0.0;
                countByCategory.merge(categoryName, qty, Double::sum);
            }
        }
        return new ArrayList<>(countByCategory.values());
    }

    @Override
    public Double getAllCustomerLoyaltyPoints() {
        double total = 0.0;
        for (Customer_Entity customer : customer_repo.findAll()) {
            total += customer.getLoyaltyPoints(); // Assuming Customer_Entity has loyaltyPoints
        }
        return total;
    }

    @Override
    public Double getOrderPercentageByTodayVsYesterday() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        int todayCount = 0;
        int yesterdayCount = 0;

        for (Order_Entity order : order_repo.findAll()) {
            if (order.getOrderDate() != null) {
                if (order.getOrderDate().equals(today)) todayCount++;
                else if (order.getOrderDate().equals(yesterday)) yesterdayCount++;
            }
        }

        if (yesterdayCount == 0) return todayCount > 0 ? 100.0 : 0.0; // Avoid division by zero
        return ((double) (todayCount - yesterdayCount) / yesterdayCount) * 100.0;
    }

    @Override
    public Double getRevenuePercentageByTodayVsYesterday() {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);

        double todayRevenue = 0.0;
        double yesterdayRevenue = 0.0;

        for (Order_Entity order : order_repo.findAll()) {
            if (order.getOrderDate() != null) {
                if (order.getOrderDate().equals(today)) todayRevenue += order.getTotalAmount();
                else if (order.getOrderDate().equals(yesterday)) yesterdayRevenue += order.getTotalAmount();
            }
        }

        if (yesterdayRevenue == 0) return todayRevenue > 0 ? 100.0 : 0.0; // Avoid division by zero
        return ((todayRevenue - yesterdayRevenue) / yesterdayRevenue) * 100.0;
    }
}
