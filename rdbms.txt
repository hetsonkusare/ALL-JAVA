✅ 1. E–R Diagram for Hospital System
Entities

Patient(PatientID, Name, Age, Gender, Address)

Doctor(DoctorID, Name, Specialization, Phone)

Test_Log (Weak Entity) (ReportID, TestName, TestDate, Result, PatientID, DoctorID)

Relationships

One Patient → Many Test Logs

One Doctor → Many Test Logs

Test_Log depends on Patient → Weak entity

E–R Diagram (ASCII Format)
           +--------------------+
           |      DOCTOR        |
           |--------------------|
           | DoctorID (PK)      |
           | Name               |
           | Specialization     |
           +----------+---------+
                      |
                      | performs
                      |
                      M
                +-------------+
                | Test_Log    |   Weak Entity
                |-------------|
                | ReportID(PK)|
                | TestName    |
                | TestDate    |
                | Result      |
                | PatientIDFK |
                | DoctorIDFK  |
                +------+------+
                       |
                       | has
                       |
                       M
           +-----------------------+
           |       PATIENT         |
           |-----------------------|
           | PatientID (PK)        |
           | Name                  |
           | Age                   |
           | Gender                |
           | Address               |
           +-----------------------+

✅ 2. Employee → Convert repeating groups into Weak Entities
Main Entity

EMPLOYEE(EmpID, Name, Address, Phone)

Weak Entities
A. DEPENDENT

Discriminator: DependentName

Attributes: DependentName, Relationship

Key: (EmpID, DependentName)

B. SKILL

Discriminator: SkillName

Attributes: SkillName

Key: (EmpID, SkillName)

C. DESIGNATION_HISTORY

Discriminator: DesignationStartDate

Attributes: Designation, DesignationStartDate

Key: (EmpID, DesignationStartDate)

D. SALARY_HISTORY

Discriminator: SalaryStartDate

Attributes: Salary, SalaryStartDate

Key: (EmpID, SalaryStartDate)

E–R Diagram Format
                   +-------------------+
                   |     EMPLOYEE      |
                   |-------------------|
                   | EmpID (PK)        |
                   | Name              |
                   | Address           |
                   | Phone             |
                   +----+----+--+------+
                        |    |  |
       ------------------    |   -------------------
       |                     |                     |
       M                     M                     M

+----------------+   +----------------+    +------------------------+
|  DEPENDENT     |   |    SKILL       |    |  DESIGNATION_HISTORY   |
|----------------|   |----------------|    |------------------------|
| DependentName  |   | SkillName      |    | Designation            |
| Relationship   |   | EmpID (FK)     |    | StartDate (Discriminator)
| EmpID (FK)     |   +----------------+    | EmpID (FK)             |
+----------------+                         +------------------------+

                                   |
                                   M
                         +----------------------+
                         |   SALARY_HISTORY     |
                         |----------------------|
                         | Salary               |
                         | SalaryStartDate      |
                         | EmpID (FK)           |
                         +----------------------+

✅ 3. People's Bank — E–R Diagram
Entities & Attributes
Client

(ClientID PK, Name, Address, Phone)

Branch

(BranchID PK, BranchName, Location)

Account

(AccountNo PK, AccountType, Balance, BranchID FK)

AccountHolder (Associative Entity)

(AccountNo FK, ClientID FK)

E–R Diagram (ASCII)
             +----------------+
             |    BRANCH      |
             |----------------|
             | BranchID (PK)  |
             | Name           |
             | Location       |
             +-------+--------+
                     |
                     | 1:M
                     |
        +--------------------------+
        |         ACCOUNT          |
        |--------------------------|
        | AccountNo (PK)           |
        | AccountType              |
        | Balance                  |
        | BranchID (FK)            |
        +------------+-------------+
                     |
              M      |      M
                     |
         +----------------------+
         |    ACCOUNT HOLDER    |
         |----------------------|
         | AccountNo (FK)       |
         | ClientID (FK)        |
         +-----------+----------+
                     |
                     | M:1
                     |
              +------------+
              |  CLIENT    |
              |------------|
              | ClientIDPK |
              | Name       |
              | Address    |
              +------------+

✅ 4. University Registration ER Diagram
Entities

Student(StudentID, Name, Email)

Course(CourseID, CourseName, Credits)

Instructor(InstructorID, Name)

Section(SectionID, CourseID, InstructorID)

Enrollment(StudentID, SectionID, Grade)

E–R Diagram (ASCII)
+-------------+       +------------+
|  STUDENT    |       |  COURSE    |
|-------------|       |------------|
| StudentIDPK |       | CourseIDPK |
| Name        |       | Name       |
+------+------|       | Credits    |
       |              +------+-----+
       | M                 | 1
       |                   |
+---------------+         +----------------+
|  ENROLLMENT   |         |   SECTION      |
|---------------|         |----------------|
| StudentID FK  |         | SectionID PK   |
| SectionID FK  |         | CourseID FK    |
| Grade         |         | InstructorIDFK |
+------+--------+         +--------+-------+
       |                           |
       |                           |
       | M                         | M
+-------------+          +------------------+
| INSTRUCTOR  |          |  DEPARTMENT (optional) |
|-------------|          +------------------+
| InstructorID|          
+-------------+

✅ 5. Add Fields to Database File
Fields to Add:
Field Name	Datatype	Description
Total	Number (3 digits)	e.g., 300 max
Percentage	Number (3,2)	e.g., 85.23
Grade	CHAR(2)	e.g., A+, B+, C
✅ 6. Create MARKSHEET Table + 3 Records
SQL
CREATE TABLE Marksheet (
  RollNo      INT PRIMARY KEY,
  Name        VARCHAR(50),
  Sub101      INT,
  Sub102      INT,
  Sub103      INT,
  Total       INT,
  Percentage  DECIMAL(5,2),
  Grade       CHAR(2)
);

Insert 3 Records
INSERT INTO Marksheet (RollNo, Name, Sub101, Sub102, Sub103)
VALUES
(1, 'Aisha', 78, 85, 92),
(2, 'Rohit', 64, 58, 72),
(3, 'Sita', 45, 52, 48);

✅ 7. UPDATE Total, Percentage, Grade
A. Update Total
UPDATE Marksheet
SET Total = Sub101 + Sub102 + Sub103;

B. Update Percentage
UPDATE Marksheet
SET Percentage = ROUND(Total / 3.0, 2);

C. Update Grade
UPDATE Marksheet
SET Grade =
  CASE
    WHEN Percentage >= 75 THEN 'A+'
    WHEN Percentage >= 60 THEN 'B+'
    WHEN Percentage >= 50 THEN 'C'
    WHEN Percentage >= 40 THEN 'D'
    ELSE 'F'
  END;

✅ 8. Display all Marksheet records
SELECT * FROM Marksheet;

✅ 9. Display Name, RollNo, 3 Marks, Total, Percentage

(Design view = select these fields)

SQL Equivalent:
SELECT Name, RollNo, Sub101, Sub102, Sub103, Total, Percentage
FROM Marksheet;

✅ 10. Display Name, RollNo, Grade
SELECT Name, RollNo, Grade
FROM Marksheet;

✅ 11. Maximum & Minimum marks for Sub101

Design view instructions:
→ Add Sub101 → Set "Total" row to Max
→ Next column Sub101 → Set "Total" row to Min

SQL Equivalent:
SELECT MAX(Sub101) AS MaxMarks, MIN(Sub101) AS MinMarks
FROM Marksheet;

✅ 12. Sum of Sub102 Marks
SELECT SUM(Sub102) AS TotalSub102
FROM Marksheet;

✅ 13. Students whose name starts with ‘A’
SELECT RollNo, Name, Percentage
FROM Marksheet
WHERE Name LIKE 'A%';

✅ 14. Students whose second letter is ‘i’

Pattern → _i%

SELECT RollNo, Name, Percentage
FROM Marksheet
WHERE Name LIKE '_i%';