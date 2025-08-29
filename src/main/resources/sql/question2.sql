-- Replace the contents of this file with the exact final SQL query for Question 2
-- Example placeholder:
SELECT
    e.EMP_ID,
    e.FIRST_NAME,
    e.LAST_NAME,
    d.DEPARTMENT_NAME,
    COUNT(CASE WHEN younger_e.DOB > e.DOB THEN 1 ELSE NULL END) AS YOUNGER_EMPLOYEES_COUNT
FROM
    EMPLOYEE e
JOIN
    DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID
LEFT JOIN
    EMPLOYEE younger_e ON e.DEPARTMENT = younger_e.DEPARTMENT AND younger_e.DOB > e.DOB
GROUP BY
    e.EMP_ID, e.FIRST_NAME, e.LAST_NAME, d.DEPARTMENT_NAME
ORDER BY
    e.EMP_ID DESC;
