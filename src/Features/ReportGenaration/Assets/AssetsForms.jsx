import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";

const AssetForm = () => {
  const initialValues = {
    assetName: "",
    assetType: "",
    dateOfPurchase: "",
    cost: "",
    Vendor:"",
  };

  const validationSchema = Yup.object({
    assetName: Yup.string().required("Asset name is required"),
    assetType: Yup.string().required("Asset type is required"),
    dateOfPurchase: Yup.date()
      .required("Date of purchase is required")
      .max(new Date(), "Date of purchase cannot be in the future")
      .min(new Date(1900, 0, 1), "Date of purchase cannot be before 1900"),
    cost: Yup.number()
      .required("Cost is required")
      .min(0, "Cost cannot be negative"),
    vendor: Yup.string().required("Vendor is required"),
    warrantyExpiration: Yup.date()
      .nullable()
      .when("dateOfPurchase", (dateOfPurchase, schema) => {
        return dateOfPurchase
          ? schema.min(
              new Date(dateOfPurchase.getTime() + 365 * 24 * 60 * 60 * 1000),
              "Warranty expiration date must be at least one year after the date of purchase"
            )
          : schema;
      }),
  });

  const onSubmit = (values) => {
    console.log(values);
  };

  return (
    <div className="form-container">
      <h1>Insert Asset Details</h1>
      <Formik
        initialValues={initialValues}
        validationSchema={validationSchema}
        onSubmit={onSubmit}
      >
        {(formik) => (
          <Form>
            <div className="form-control">
              <label htmlFor="assetName">Asset Name</label>
              <Field type="text" id="assetName" name="assetName" />
              <ErrorMessage name="assetName" />
            </div>

            <div className="form-control">
              <label htmlFor="assetType">Asset Type</label>
              <Field type="text" id="assetType" name="assetType" />
              <ErrorMessage name="assetType" />
            </div>

            <div className="form-control">
              <label htmlFor="dateOfPurchase">Date of Purchase</label>
              <Field type="date" id="dateOfPurchase" name="dateOfPurchase" />
              <ErrorMessage name="dateOfPurchase" />
            </div>

            <div className="form-control">
              <label htmlFor="cost"> Purchase Cost</label>
              <Field type="number" id="cost" name="cost" />
              <ErrorMessage name="cost" />
            </div>

            <div className="form-control">
              <label htmlFor="Vendor">Vendor</label>
              <Field type="text" id="Vendor" name="Vendor" />
              <ErrorMessage name="Vendor" />
            </div>

            <button type="submit" disabled={!formik.isValid}>
              Submit
            </button>
          </Form>
        )}
      </Formik>
    </div>
  );
};

export default AssetForm;
