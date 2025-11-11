package serviceF1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import repositoryF1.RepositoryF1;

public class ServiceF1 {

	private static final Logger logger = LogManager.getLogger(RepositoryF1.class);

	private RepositoryF1 repo;

	public ServiceF1(RepositoryF1 repo) {
		super();
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "ServiceF1 [repo=" + repo + "]";
	}

	public RepositoryF1 getRepo() {
		return repo;
	}

	public void setRepo(RepositoryF1 repo) {
		this.repo = repo;
	}
	
	
}
