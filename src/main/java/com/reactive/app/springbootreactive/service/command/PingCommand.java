package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.model.request.ServiceRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface PingCommand extends Command<String, ServiceRequest>{
}
