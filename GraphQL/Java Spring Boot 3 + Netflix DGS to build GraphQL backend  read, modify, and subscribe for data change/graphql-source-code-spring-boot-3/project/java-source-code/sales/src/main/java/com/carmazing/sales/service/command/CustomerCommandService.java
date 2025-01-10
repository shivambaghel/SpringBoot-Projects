package com.carmazing.sales.service.command;

import com.carmazing.sales.datasource.entity.Customer;
import com.carmazing.sales.datasource.entity.CustomerDocument;
import com.carmazing.sales.datasource.repository.CustomerRepository;
import com.carmazing.sales.generated.types.AddAddressInput;
import com.carmazing.sales.generated.types.AddCustomerInput;
import com.carmazing.sales.generated.types.UpdateCustomerInput;
import com.carmazing.sales.mapper.AddressMapper;
import com.carmazing.sales.mapper.CustomerMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class CustomerCommandService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addNewCustomer(AddCustomerInput addCustomerInput) {
        var customerEntity = CustomerMapper.mapToEntity(addCustomerInput);

        return customerRepository.save(customerEntity);
    }

    public Customer addAddressesToExistingCustomer(
            Customer customer, List<AddAddressInput> addressList
    ) {
        var addressesEntity = addressList.stream()
                .map(AddressMapper::mapToEntity).toList();

        customer.getAddresses().addAll(addressesEntity);

        return customerRepository.save(customer);
    }

    public Customer addDocumentToExistingCustomer(
        Customer customer, String documentType, MultipartFile documentFile
    ) {
        var documentEntity = new CustomerDocument();
        documentEntity.setDocumentType(documentType);

        // pretend process upload, e.g. to S3 bucket or other storage
        var uploadedDocumentPath = String.format("%s/%s/%s-%s-%s",
                "https://dummy-storage.com", customer.getUuid(), documentType,
                RandomStringUtils.randomAlphabetic(6).toLowerCase(),
                documentFile.getOriginalFilename());

        documentEntity.setDocumentPath(uploadedDocumentPath);

        customer.getDocuments().add(documentEntity);

        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Customer customer, UpdateCustomerInput customerUpdate) {
        if (StringUtils.isNotBlank(customerUpdate.getEmail())) {
            customer.setEmail(customerUpdate.getEmail());
        }

        if (StringUtils.isNotBlank(customerUpdate.getPhone())) {
            customer.setPhone(customerUpdate.getPhone());
        }

        return customerRepository.save(customer);
    }

}
