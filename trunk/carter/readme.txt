#-- Dumping the database so it can be imported --#
mysqldump --opt -ucarterdb -pHestemParto --single-transaction carter user role user_role city course course_city golf_match registration regentry season season_match bracket private_message public_message ticker champion  > carter_dump.sql


#-- The following can be run on the server to forward port 80 to 8080 where tomcat is running --#
iptables -t nat -A PREROUTING -p tcp --dport 80 -i eth0 -j REDIRECT --to-port 8080


# -- Pages to convert --#
^^^about.jsp
^^^champions.jsp
choosecity.jsp
^^^contact.jsp
^^^coursedetails.jsp
^^^courses.jsp
dataAccessFailure.jsp
default.jsp*
error.jsp*
^^^home.jsp (needs public message board)
^^^inbox.jsp
^^^index.jsp*
login.jsp*
loginForm.jsp
^^^members.jsp
^^^msgboard.jsp
^^^playoffs.jsp
^^^printcard.jsp
^^^profile.jsp
^^^record.jsp
^^^registration.jsp
^^^results.jsp
^^^rules.jsp
^^^schedule.jsp
^^^sendMessage.jsp
[[[signup.jsp]]] - replaced with updates to userForm.jsp
^^^standings.jsp
^^^userForm.jsp
^^^viewresults.jsp
^^^403.jsp*
^^^404.jsp*

activeUsers.jsp
adminInbox.jsp
clickstreams.jsp*
courseForm.jsp
flushCache.jsp
manageRegistration.jsp
[[[processCreditCards.jsp]]] - not used anymore
[[[processCreditCard.jsp]]] - not used anymore
registrationForm.jsp
scheduleSeason.jsp
test.jsp
testCreateUsers.jsp
testPlayPostSeason.jsp
testPlayRegularSeason.jsp
underpar.jsp
userList.jsp
viewSeason.jsp
viewstream.jsp*

TODO (as of 5/26/2010)
----------------------
· Add Charlie to webtrac
· Create a sample regular season that is played approximately three quarters through the season. Users can access this through the city selection. The city will be named sample season.
· Create a playoff season that is through the quarter finals. Users will also access this through the city selection. The city will be named sample playoff season.
· Add ability to delete your own postings from the public message board. Also add a link to the public message board for posting on the home page.
· Add payment page and determine best way for players to access this. Yes! I’m ready to tee off with city golf league. No, I still need a little work on my short game.
· Flash loading screen.
· Change to 4 week season
· View message board from home screen
Revision 532 contains all the credit card processing stuff that was deleted.
