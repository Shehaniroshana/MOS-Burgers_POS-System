package MOS.ecom.controller;

import MOS.ecom.service.Dashboard_Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mos/dashboard")
@CrossOrigin
public class Dashboard {

    private final Dashboard_Service dashboard_service;

    @GetMapping("/revenue/current-month")
    public Double getTotalRevenueByCurrentMonth() {
        return dashboard_service.getTotalRevenueInCurrentMonth();
    }

    @GetMapping("/revenue/last-6-months")
    public List<Object> getRevenueByLast6Month() {
        return dashboard_service.getRevenueByLast6Month();
    }

    @GetMapping("/revenue/today")
    public Double getTotalRevenueToday() {
        return dashboard_service.getTotalRevenueToday();
    }
    @GetMapping("/revenue/yesterday")
    public Double getTotalRevenueYesterday() {
        return dashboard_service.getTotalRevenueYesterday();
    }

    @GetMapping("/revenue/total")
    public Double getTotalRevenue() {
        return dashboard_service.getTotalRevenue();
    }

    @GetMapping("/revenue/percentage-today-vs-yesterday")
    public Double getRevenuePercentageByTodayVsYesterday() {
        return dashboard_service.getRevenuePercentageByTodayVsYesterday();
    }

    @GetMapping("/orders/count")
    public Integer getAllOrderCount() {
        return dashboard_service.getAllOrderCount();
    }

    @GetMapping("/orders/count-by-status")
    public List<Object> getAllOrderCountByStatus() {
        return dashboard_service.getAllOrderCuntByStatus();
    }

    @GetMapping("/orders/percentage-today-vs-yesterday")
    public Double getOrderPercentageByTodayVsYesterday() {
        return dashboard_service.getOrderPercentageByTodayVsYesterday();
    }

    @GetMapping("/items/total-count")
    public Double getAllItemCount() {
        return dashboard_service.getItemAllItemCount();
    }

    @GetMapping("/items/count-by-category")
    public List<Object> getItemAllItemCountByCategory() {
        return dashboard_service.getItemAllItemCountByCategory();
    }

    @GetMapping("/customers/count")
    public Integer getAllCustomerCount() {
        return dashboard_service.getAllCustomerCount();
    }

    @GetMapping("/customers/loyalty-points")
    public Double getAllCustomerLoyaltyPoints() {
        return dashboard_service.getAllCustomerLoyaltyPoints();
    }
}
