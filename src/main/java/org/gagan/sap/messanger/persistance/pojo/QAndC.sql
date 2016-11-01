
insert  into assessment(ASSESMENT_TYPE,VERSION_ID) values('Basic Health',0);
insert  into assessment(ASSESMENT_TYPE,VERSION_ID) values('vision',0);
insert  into assessment(ASSESMENT_TYPE,VERSION_ID) values('Hearing',0);
insert  into assessment(ASSESMENT_TYPE,VERSION_ID) values('Dental',0);




/*Basic Health*/
select ID into @ID from assessment where ASSESMENT_TYPE='Basic Health';
insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Height','FreeText-FLoat',@ID,0);
insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Weight','FreeText-FLoat',@ID,0);
insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('BMI','FreeText-FLoat',@ID,0);
insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Blood Pressure','FreeText-FLoat', @ID,0);
insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('ECG-Image-Path','FreeText-ImagePath',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('ECG-COMMENTS','FreeText-String',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Any breathing problem/ Asthma','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Any breathing problem/ Asthma';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee have any Nasal allergies','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee have any Nasal allergies';
 insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee have any Skin Allergies','Single-Value-Choice',@ID,0);
 select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee have any Skin Allergies';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee Smoke','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee Smoke';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee consume Alcohol','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee consume Alcohol';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee have Tonsilliti','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee have Tonsilliti';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Do you experience Swelling in any body parts (abdomen, leg, hand)','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Do you experience Swelling in any body parts (abdomen, leg, hand)';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Swelling in body parts (abdomen, leg, hand) Comments','FreeText-Text',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('History of any head injury','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='History of any head injury','Single-Value-Choice';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Are you Under any medication or treatment','Single-Value-Choice',@ID,0);
 select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Are you Under any medication or treatment';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has any Hunger problem','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has any Hunger problem';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee has normal Sleep','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee has normal Sleep';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has any Cardiac problem','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has any Cardiac problem';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);





/*Vision*/
select ID into @ID from assessment where ASSESMENT_TYPE='vision';
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Left Visual Acuity',FreeText-FLoat,@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Left Spherical',FreeText-FLoat,@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Left Cylindrical',FreeText-FLoat,@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Left Axis',FreeText-FLoat,@ID,0);


insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Right Visual Acuity',FreeText-FLoat,@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Right Spherical','FreeText-FLoat',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Right Cylindrical','FreeText-FLoat',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Right Axis','FreeText-FLoat',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Squint','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Squint';
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Conjunctiva','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Conjunctiva';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Color vision','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Color vision';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Normal','String',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('abnormal','String',@questionId,0);
insert  into  ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Cataract','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Cataract';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Pterygium','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Pterygium';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Glaucoma','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Glaucoma';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Is the employee wearing spectacles or lens','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Is the employee wearing spectacles or lens';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Is there any red or watery crust in the eye','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Is there any red or watery crust in the eye';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Is the Employee rubbing eyes frequently','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Is the Employee rubbing eyes frequently';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Is the Employee unusually sensitive to bright light','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Is the Employee unusually sensitive to bright light';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have night blindness','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have night blindness';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee has headache after working for long time','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee has headache after working for long time';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee has Discharge from eyes / Sticky eyes','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee has Discharge from eyes / Sticky eyes';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does The employee referred to ophthalmologist','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does The employee referred to ophthalmologist';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);



/*Hearing*/
select ID into @ID from assessment where ASSESMENT_TYPE='Hearing';
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Right Ear Audiogram','FreeText-String',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Left Ear Audiogram','FreeText-String',@ID,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has any history of ear Discharge','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has any history of ear Discharge';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has any history of Vertigo','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has any history of Vertigo';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has Ringing sensation in the ear','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has Ringing sensation in the ear';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee has Ear Wax','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee has Ear Wax';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the employee Need Detailed Hearing Evaluation','Single-Value-Choice',@ID,0)
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the employee Need Detailed Hearing Evaluation';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);


insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Any Referral to ENT specialist','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Any Referral to ENT specialist';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Any Referral to Audiologist','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Any Referral to Audiologist';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);


/*Dental*/
select ID into @ID from assessment where ASSESMENT_TYPE='Dental';
insert  into 
ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Tooth Status','FreeText-String',@ID,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have any Bad Breathe','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have any Bad Breathe';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);


insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have any Tooth Pain','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have any Tooth Pain';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);


insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have any Bleeding gums','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have any Bleeding gums';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have any Sensitivity problem','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have any Sensitivity problem';
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into   ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have any Discoloured or Yellowish  teeth','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have any Discoloured or Yellowish  teeth';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);


insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee have Smoking habit','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee have Smoking habit';
insert  into     ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into     ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Does the Employee use any Mouth wash','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Does the Employee use any Mouth wash';
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into    ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);

insert  into ASSESSMENT_QUESTION(QUESTION,QUESTION_TYPE,ASSESSMENT_ID,VERSION_ID) values('Any Referral to dentist','Single-Value-Choice',@ID,0);
select ID into @questionId from ASSESSMENT_QUESTION where QUESTION='Any Referral to dentist';
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('Yes','Boolean',@questionId,0);
insert  into  ASSESSMENT_QUESTION_CHOICE(CHOICE_VALUE,CHOICE_TYPE,ASSESSMENT_QUESTION_ID,VERSION_ID) values('No','Boolean',@questionId,0);






