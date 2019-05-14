/* tslint:disable no-unused-expression */
import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { SaleComponentsPage, SaleDeleteDialog, SaleUpdatePage } from './sale.page-object';

const expect = chai.expect;

describe('Sale e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let saleUpdatePage: SaleUpdatePage;
  let saleComponentsPage: SaleComponentsPage;
  let saleDeleteDialog: SaleDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Sales', async () => {
    await navBarPage.goToEntity('sale');
    saleComponentsPage = new SaleComponentsPage();
    await browser.wait(ec.visibilityOf(saleComponentsPage.title), 5000);
    expect(await saleComponentsPage.getTitle()).to.eq('Sales');
  });

  it('should load create Sale page', async () => {
    await saleComponentsPage.clickOnCreateButton();
    saleUpdatePage = new SaleUpdatePage();
    expect(await saleUpdatePage.getPageTitle()).to.eq('Create or edit a Sale');
    await saleUpdatePage.cancel();
  });

  it('should create and save Sales', async () => {
    const nbButtonsBeforeCreate = await saleComponentsPage.countDeleteButtons();

    await saleComponentsPage.clickOnCreateButton();
    await promise.all([
      saleUpdatePage.setQuantityInput('5')
      // saleUpdatePage.productSelectLastOption(),
    ]);
    expect(await saleUpdatePage.getQuantityInput()).to.eq('5', 'Expected quantity value to be equals to 5');
    await saleUpdatePage.save();
    expect(await saleUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await saleComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Sale', async () => {
    const nbButtonsBeforeDelete = await saleComponentsPage.countDeleteButtons();
    await saleComponentsPage.clickOnLastDeleteButton();

    saleDeleteDialog = new SaleDeleteDialog();
    expect(await saleDeleteDialog.getDialogTitle()).to.eq('Are you sure you want to delete this Sale?');
    await saleDeleteDialog.clickOnConfirmButton();

    expect(await saleComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
