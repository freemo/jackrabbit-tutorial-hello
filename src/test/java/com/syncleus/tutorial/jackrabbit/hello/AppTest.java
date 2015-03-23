package com.syncleus.tutorial.jackrabbit.hello;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import javax.jcr.LoginException;
import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.core.TransientRepository;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws LoginException, RepositoryException
    {
    	Repository repo = new TransientRepository();
    	Session session = repo.login(
    			new SimpleCredentials("admin","admin".toCharArray()));
    	Node root = session.getRootNode();
    	
    	NodeIterator i = root.getNodes();
    	while(i.hasNext()){
    		Node node = i.nextNode();
    		System.out.println(node.getName());
    	}
    	
        session.logout();
    }
}
