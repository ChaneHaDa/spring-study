package com.chan.springauthorizationserver;

import com.chan.springauthorizationserver.client.JpaRegisteredClientRepository;
import com.chan.springauthorizationserver.user.authority.Authority;
import com.chan.springauthorizationserver.user.authority.AuthorityRepository;
import com.chan.springauthorizationserver.user.customer.Customer;
import com.chan.springauthorizationserver.user.customer.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.core.oidc.OidcScopes;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.security.oauth2.server.authorization.settings.TokenSettings;

import java.time.Duration;
import java.util.UUID;

@SpringBootTest
class SpringAuthorizationServerApplicationTests {

	@Autowired
	private JpaRegisteredClientRepository registeredClientRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AuthorityRepository authorityRepository;

	@Test
	void contextLoads() {
		RegisteredClient oidcClient = RegisteredClient.withId(UUID.randomUUID().toString())
				.clientId("my-client")
				.clientSecret("{noop}mypassword")
				.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
				.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
				.authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
				.redirectUri("http://localhost:3000")
				.postLogoutRedirectUri("http://localhost:3000/")
				.scope(OidcScopes.OPENID)
				.scope(OidcScopes.PROFILE)
				.clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
				.tokenSettings(TokenSettings.builder().accessTokenTimeToLive(Duration.ofSeconds(360)).build())
				.build();
		registeredClientRepository.save(oidcClient);

		Customer customer = new Customer(0L, "admin", "example@com", "1234");
		Customer savedCusomer = customerRepository.save(customer);

		Authority authority = new Authority(0L, "ADMIN", savedCusomer);
		authorityRepository.save(authority);
	}

}
