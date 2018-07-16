/*
 * TestCreateUsersController.java
 * 
 * Copyright © 2008-2009 City Golf League, LLC.  All Rights Reserved
 * http://www.citygolfleague.com
 * 
 * @author Steve Paquin - Sage Software Consulting, Inc.
 */
package com.sageconsulting.webapp.action;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;

import com.sageconsulting.Constants;
import com.sageconsulting.model.City;
import com.sageconsulting.model.Course;
import com.sageconsulting.model.Registration;
import com.sageconsulting.model.RegistrationEntry;
import com.sageconsulting.model.Role;
import com.sageconsulting.model.User;
import com.sageconsulting.service.CityManager;
import com.sageconsulting.service.CourseManager;
import com.sageconsulting.service.RegistrationEntryManager;
import com.sageconsulting.service.RegistrationManager;
import com.sageconsulting.service.UserExistsException;
import com.sageconsulting.util.StringUtil;
import com.sageconsulting.webapp.util.CustomCityEditor;

public class TestCreateUsersController extends BaseFormController
{
    private RegistrationManager registrationManager;
    private RegistrationEntryManager registrationEntryManager;
    private CityManager cityManager;
    private CourseManager courseManager;
    
    public void setRegistrationManager(RegistrationManager mgr)
    {
        this.registrationManager = mgr;
    }
    
    public void setRegistrationEntryManager(RegistrationEntryManager mgr)
    {
        this.registrationEntryManager = mgr;
    }
    
    public void setCityManager(CityManager mgr)
    {
        this.cityManager = mgr;
    }
    
    public void setCourseManager(CourseManager mgr)
    {
        this.courseManager = mgr;
    }
    
    public TestCreateUsersController()
    {
        super();
        setCommandName("createUserInfo"); //$NON-NLS-1$
        setCommandClass(CreateUserInfo.class);
    }
    
    @Override
    public ModelAndView showForm(HttpServletRequest request, HttpServletResponse response, BindException errors) throws Exception
    {
        ModelAndView view = super.showForm(request, response, errors);
        view.addObject("cityList", getCities()); //$NON-NLS-1$
        return view;
    }

    private List<City> getCities()
    {
        return this.cityManager.getCities();
    }

    @Override
    public ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command,
        BindException errors) throws Exception
    {
        if (this.log.isDebugEnabled())
        {
            this.log.debug("entering 'onSubmit' method..."); //$NON-NLS-1$
        }

        CreateUserInfo createUserInfo = (CreateUserInfo)command;
        createSeason(request, createUserInfo);

        return super.onSubmit(request, response, command, errors);
    }

    /**
     * Set up a custom property editor for converting form inputs to real
     * objects.
     * @param request The current request.
     * @param binder The object which binds an input to a custom editor.
     */
    @Override
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
        binder.registerCustomEditor(City.class, null, new CustomCityEditor(this.cityManager.getCities()));
        super.initBinder(request, binder);
    }
    
    @Override
    public Object formBackingObject(HttpServletRequest request) throws Exception
    {
        CreateUserInfo info = (CreateUserInfo)super.formBackingObject(request);
        if (null == info.getSeasonName())
        {
            info.setSeasonName("Test Season"); //$NON-NLS-1$
        }
        if (info.getUserCount() < 1)
        {
            info.setUserCount(300);
        }
        return info;
    }
    
    private void createSeason(HttpServletRequest request, CreateUserInfo info) throws UserExistsException
    {
        Registration registration = new Registration();
        registration.setDisplayName(info.getSeasonName());
        registration.setCity(info.getCity());
        GregorianCalendar gc = new GregorianCalendar();
        registration.setRegistrationEnd(gc.getTime());
        gc.add(Calendar.DAY_OF_YEAR, -7);
        registration.setRegularRegistrationStart(gc.getTime());
        gc.add(Calendar.DAY_OF_YEAR, -7);
        registration.setEarlyRegistrationStart(gc.getTime());
        this.registrationManager.saveRegistration(registration);
        
        registerUsers(registration, info.getUserCount(), info.getCity());

        super.saveMessage(request, "Created "+info.getUserCount()+ //$NON-NLS-1$
            "  user and added them to season '"+info.getSeasonName()+"'."); //$NON-NLS-1$ //$NON-NLS-2$
    }
    
    private void registerUsers(Registration registration, int userCount, City city) throws UserExistsException
    {
        List<Course> courses = this.courseManager.getCourses(city.getId());
        Random random = new Random();
        Date dateJoined = new Date();
        for (int i=0; i<userCount; i++)
        {
            int idx = random.nextInt(courses.size()-1)+1;
            User user = createUser(i, courses.get(idx), dateJoined, city);
            registerUser(registration, user);
        }
    }
    
    private User createUser(int userid, Course course, Date dateJoined, City city) throws UserExistsException
    {
        User user = new User();
        user.setUsername("testuser"+userid); //$NON-NLS-1$
        user.setFirstName("Test"); //$NON-NLS-1$
        user.setLastName("User"+userid); //$NON-NLS-1$
        /*user.setHandicap(createHandicap(40));
        
        user.setGhinNumber(""+userid); //$NON-NLS-1$
*/        user.setPassword(encryptPassword("test1234")); //$NON-NLS-1$
        user.setPasswordHint("test1234"); //$NON-NLS-1$
        user.getAddress().setAddress("1234 Main St."); //$NON-NLS-1$
        user.getAddress().setCity("Portland"); //$NON-NLS-1$
        user.getAddress().setProvince("OR"); //$NON-NLS-1$
        user.getAddress().setPostalCode("97222"); //$NON-NLS-1$
        user.setEmail(user.getUsername()+"@citygolfleague.com"); //$NON-NLS-1$
        user.setAccountExpired(false);
        user.setAccountLocked(false);
        user.setCredentialsExpired(false);
        user.addRole(new Role(Constants.USER_ROLE));
        user.setCellPhone("5031234567"); //$NON-NLS-1$
        user.setHomePhone("5031234567"); //$NON-NLS-1$
        user.setPreferredPhone(0);
        user.setEnabled(true);
        user.setMale(true);
        //user.setHomeCourt(course);
        user.setDateJoined(dateJoined);
        user.setRegisteredCity(city);
        user.setDateJoined(new Date());
        user.setReferral("test"); //$NON-NLS-1$
        user.setIcon("images/maleGolfer-icon.jpg"); //$NON-NLS-1$
        
        getUserManager().saveUser(user);
        return user;
    }
    
    private String encryptPassword(String pwd)
    {
        String algorithm = (String)getConfiguration().get(Constants.ENC_ALGORITHM);
        return StringUtil.encodePassword(pwd, algorithm);
    }
    
    private Double createHandicap(int max)
    {
        Double handicap = Double.valueOf(Math.random()*max);
        BigDecimal val = new BigDecimal(handicap.doubleValue());
        BigDecimal newval = val.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        return Double.valueOf(newval.doubleValue());
    }
    
    private void registerUser(Registration registration, User user)
    {
        RegistrationEntry entry = new RegistrationEntry();
        entry.setPaymentType(Integer.valueOf(2));
        entry.setRegistration(registration);
        entry.setUser(user);
        this.registrationEntryManager.saveRegistrationEntry(entry);
    }
    
    public static final class CreateUserInfo
    {
        private String seasonName;
        private int nUsers;
        private City city;
        
        public String getSeasonName() { return this.seasonName; }
        public void setSeasonName(String name) { this.seasonName = name; }
        
        public int getUserCount() { return this.nUsers; }
        public void setUserCount(int count) { this.nUsers = count; }
        
        public City getCity() { return this.city; }
        public void setCity(City c) { this.city = c; }
    }
}
