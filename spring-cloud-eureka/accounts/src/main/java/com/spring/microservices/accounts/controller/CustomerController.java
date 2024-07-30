package com.spring.microservices.accounts.controller;


import com.spring.microservices.accounts.dto.CustomerDetailsDto;
import com.spring.microservices.accounts.dto.ErrorResponseDto;
import com.spring.microservices.accounts.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "REST API Customers",
        description = "REST API Customers"
)
@RestController
@RequestMapping("/api")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @Operation(
            summary = "Fetch Customer Details REST API",
            description = "REST API to fetch Customer,Account,Cards and Loans details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchAccountDetails(@RequestParam
                                                                  @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
                                                                  String mobileNumber) {

        CustomerDetailsDto customerByMobileNumber = customerService.getCustomerByMobileNumber(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(customerByMobileNumber);
    }

}
