package com.pluralsight.fundamentals.service;

import com.pluralsight.fundamentals.entity.Ticket;

public interface TicketService {
    Iterable<Ticket> listTickets();
}

