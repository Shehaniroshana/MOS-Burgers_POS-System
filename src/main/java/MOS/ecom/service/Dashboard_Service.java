package MOS.ecom.service;

import java.util.List;

public interface Dashboard_Service {
    public Double getTotalRevenueInCurrentMonth();
    public List<Object> getRevenueByLast6Month();
    public Integer getAllCustomerCount();
    public Integer getAllOrderCount();
    public List<Object> getAllOrderCuntByStatus();
    public Double getTotalRevenueToday();
    public Double getTotalRevenueYesterday();
    public Double getTotalRevenue();
    public Double getItemAllItemCount();
    public List<Object> getItemAllItemCountByCategory();
    public Double getAllCustomerLoyaltyPoints();
    public Double getOrderPercentageByTodayVsYesterday();
    public Double getRevenuePercentageByTodayVsYesterday();

}
